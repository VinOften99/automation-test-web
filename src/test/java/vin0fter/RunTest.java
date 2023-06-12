package vin0fter;

import Testcase.TE001;
import Testcase.TE002;
import Testcase.TE003;
import Testcase.TE004;

public class RunTest {
    public static void main(String[] args) {
        runTE001();
        runTE002();
        runTE003();
        runTE004();
    }

    public static void runTE001() {
        TE001.main(new String[]{});
    }

    public static void runTE002() {
        TE002.main(new String[]{});
    }

    public static void runTE003() {
        TE003.main(new String[]{});
    }

    public static void runTE004() {
        TE004.main(new String[]{});
    }
}
