package prostmk.Model.Inner;

public class InnerClasses {



    public enum Type{
        FirstType,SecondType,ThirdType
    }

    public static class InClass{
        public void print(String sa){
            System.out.println(sa);
        }

        public static void staticPrint(String text){
            System.out.println(text);
        }
    }

    public class InNonStaticClass{
        public void print(){
            System.out.println("hey, i am non static class and non static method !!!!");
        }
    }


    public static void checkType(Type type){
        if (type.equals(Type.FirstType)){
            System.out.println("first");
        }else if (type.equals(Type.SecondType)){
            System.out.println("second");
        }else{
            System.out.println("third");
        }
    }



    public InNonStaticClass getObjectOfNonStaticInnerClass(){
        return new InNonStaticClass();
    }




}
