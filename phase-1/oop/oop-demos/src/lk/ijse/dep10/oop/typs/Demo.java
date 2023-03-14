package lk.ijse.dep10.oop.typs;

public class Demo {
    public static void main(String[] args) {
        TopLevelClass topLevelClass = new TopLevelClass();
        AnotherTopLevelClass anotherTopLevelClass = new AnotherTopLevelClass();

        new TopLevelClass.StaticNestedClass();
        topLevelClass.new RegularInnerClass();

        int x = 10;
        class LocalInnerClass{

        }

        new LocalInnerClass();

    }
}

class TopLevelClass{
    class RegularInnerClass{
        int x =10;
        {
            int x = 10;
            class localInnerClass{

            }
        }

    }

    static class StaticNestedClass{

    }
}

class AnotherTopLevelClass{

}
