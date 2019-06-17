package interfaces;

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
        System.out.println("interfaces.UsbMouse open...");
    }

    public void close() {
        System.out.println("interfaces.UsbMouse close...");
    }
}

class KeyBoard implements USB {
    public void open() {
        System.out.println("interfaces.KeyBoard open...");
    }

    public void close() {
        System.out.println("interfaces.KeyBoard close...");
    }
}

class NeteBook {
    public void run() {
        System.out.println("interfaces.NeteBook Run...");
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
        System.out.println("interfaces.Fu...");
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
        System.out.println("interfaces.Zi...");
    }

    void show() {
        System.out.println("num = " + num);
    }

}

class UsbTest {
    public static void main(String[] args) {
        /*
         * interfaces.NeteBook nb = new interfaces.NeteBook(); nb.run(); nb.useUsb(new interfaces.UsbMouse());
         * nb.useUsb(new interfaces.KeyBoard());
         */

        Fu f = new Zi();
        f.show(); // 访问成员变量时候，本类引用
    }
}