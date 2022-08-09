package ThreadSafeDoubleCheck;

public class ThreadSafeDoubleCheckInitialization {
    
//    Thread safe singleton’a bir diğer yaklaşım ise double check yöntemidir.
//    Bu yöntemde sadece instance oluşturulurken sınıf senkronize edileceğinden performans sorununa da yol açmaz.

    private static ThreadSafeDoubleCheckInitialization instance;

    private ThreadSafeDoubleCheckInitialization() {

    }

    public static ThreadSafeDoubleCheckInitialization getInstance() {

        if (instance == null) {

            synchronized (ThreadSafeDoubleCheckInitialization.class) {

                if (instance == null) {

                    instance = new ThreadSafeDoubleCheckInitialization();

                }

            }
        }
        return instance;
    }

}
