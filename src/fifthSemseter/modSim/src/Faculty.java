package fifthSemseter.modSim.src;

public class Faculty {

public int getFaculty(int n) {
        return (n==0) ? 1 : n * getFaculty(n-1);
//        if(n == 0)
//            return 1;
//        else
//            return n * faculty(n-1);
    }
}
