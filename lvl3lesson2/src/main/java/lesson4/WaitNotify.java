package lesson4;

public class WaitNotify {
    private final Object mon = new Object();//монитор
    private char letter = 'Q';

    public static void main(String[] args) {
        WaitNotify wn = new WaitNotify();

        new Thread(wn::printQ).start();
        new Thread(wn::printR).start();
    }

    public void printQ() {
        synchronized (mon) {//синхронизируем поток по монитору mon
            try {
                for (int i = 0; i < 5; i++) {
                    while (letter != 'Q') {
                        mon.wait();//поток засыпает и освобождает монитор
                    }
                    System.out.println(letter);
                    letter = 'R';
                    mon.notifyAll();
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void printR() {
       synchronized (mon) {//синхронизируем поток по монитору mon
            try {
                for (int i = 0; i < 5; i++) {
                    while (letter != 'R') {
                       mon.wait();
                    }
                    System.out.println(letter);
                    letter = 'Q';
                    mon.notifyAll();
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
