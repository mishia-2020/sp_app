package core.infrastructure;


public class DbConstEnum {
    enum book{
        B1(1),
        B2(2),
        B3(3),
        B4(4);

        private final int code;

        private book(final int code) {
            this.code = code;
        }

        public int getCode(){
            return this.code;
        }
    }

    enum animal{
        Dog,
        Cat,
        Mouse,
        Monkey;
    }
}


