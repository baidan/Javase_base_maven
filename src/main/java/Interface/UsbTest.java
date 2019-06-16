package Interface;

interface USB {
    public void open();

    public void close();
}

class Mouse {
    public void show() {
        System.out.println("show mouse...");
    }
}

class UsbMouse extends Mouse implements USB {
    public void open() {
        System.out.println("Interface.UsbMouse open...");
    }

    public void close() {
        System.out.println("Interface.UsbMouse close...");
    }
}

class KeyBoard implements USB {
    public void open() {
        System.out.println("Interface.KeyBoard open...");
    }

    public void close() {
        System.out.println("Interface.KeyBoard close...");
    }
}

class NeteBook {
    public void run() {
        System.out.println("Interface.NeteBook Run...");
    }

    public void useUsb(USB usb) {
        if (usb != null) {
            usb.open();
            // usb.close();
        }
    }
}

class Fu {
    int num = 5;

    {
        System.out.println("num1111 = " + num);
    }

    Fu() {
        System.out.println("Interface.Fu...");
    }

    void show() {
        System.out.println("num = " + num);
    }
}

class Zi extends Fu {
    int num = 6;

    {
        System.out.println("num2222 = " + num);
    }

    Zi() {
        System.out.println("Interface.Zi...");
    }

    void show() {
        System.out.println("num = " + num);
    }

}

class UsbTest {
    public static void main(String[] args) {
        /*
         * Interface.NeteBook nb = new Interface.NeteBook(); nb.run(); nb.useUsb(new Interface.UsbMouse());
         * nb.useUsb(new Interface.KeyBoard());
         */

        Fu f = new Zi();
        f.show(); // 访问成员变量时候，本类引用
    }
}