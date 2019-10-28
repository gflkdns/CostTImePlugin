package plugin;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.AdviceAdapter;

import me.wangyuwei.costtime.Cost;

/**
 * 巴掌
 * https://github.com/JeasonWong
 */

public class CostClassVisitor extends ClassVisitor {

    boolean enable, costAll;

    public CostClassVisitor(ClassVisitor classVisitor, boolean enable, boolean costAll) {
        super(Opcodes.ASM5, classVisitor);
        this.enable = enable;
        this.costAll = costAll;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature,
                                     String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
        mv = new AdviceAdapter(Opcodes.ASM5, mv, access, name, desc) {

            private boolean inject = false;

            @Override
            public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
                if (Type.getDescriptor(Cost.class).equals(desc)) {
                    inject = true;
                }
                return super.visitAnnotation(desc, visible);
            }

            @Override
            protected void onMethodEnter() {
                if (isInject()) {
                    mv.visitLdcInsn(name);
                    mv.visitMethodInsn(Opcodes.INVOKESTATIC, "me/wangyuwei/costtime/TimePrint", "start", "(Ljava/lang/String;)V", false);
                }
            }

            private boolean isInject() {
                return enable && (costAll || inject);
            }

            @Override
            protected void onMethodExit(int opcode) {
                if (isInject()) {
                    mv.visitLdcInsn(name);
                    mv.visitMethodInsn(Opcodes.INVOKESTATIC, "me/wangyuwei/costtime/TimePrint", "end", "(Ljava/lang/String;)V", false);
                }
            }
        };
        return mv;
    }
}
