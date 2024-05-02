package hashing;

import java.util.Date;

import static java.lang.Double.doubleToLongBits;

public class Hashing {
    private final class Integer {
        private final int value;

        private Integer(int value) {
            this.value = value;
        }

        public int hashCode() {
            return value;
        }
    }

    private final class Double {
        private final double value;

        private Double(double value) {
            this.value = value;
        }

        public int hashCode() {
            long bits = doubleToLongBits(value);
            return (int) (bits ^ (bits >>> 32));
        }
    }

    private final class Boolean {
        private final boolean value;

        private Boolean(boolean value) {
            this.value = value;
        }

        public int hashCode() {
            if (value) return 1231;
            return 1237;
        }
    }

    private final class String {
        private int hash = 0;
        private final char[] value;

        private String(char[] value) {
            this.value = value;
        }

        public int hashCode() {
            int h = hash;
            if (h != 0) return h;
            for (char c : value) {
                h = c + (31 * h);
            }
            hash = h;
            return hash;
        }
    }

    private final class CustomClass {
        private final String name;
        private final double age;
        private final Date birthDate;

        private CustomClass(String name, double age, Date birthDate) {
            this.name = name;
            this.age = age;
            this.birthDate = birthDate;
        }

        public int hashCode() {
            int hash = 17;
            hash = 31 * hash + name.hashCode();
            hash = 31 * hash +  ((java.lang.Double) age).hashCode();
            hash = 31 * hash + birthDate.hashCode();
            return hash;
        }
    }
}
