public class prefixArray {


     void sum(int A[],int len, int p[]){
p[0] = A[0];
for(int i = 1;i< len;i++){
    p[i] =p[i-1]+A[i];

}
    }


    public static void main(String[] args) {
   prefixArray pre = new prefixArray();
        int  A[] = {1,3,5,6,7};
        int len = A.length;
        int p[] = new int[len];

    pre.sum(A,len,p);
    for(int k = 0;k<len; k++){
    System.out.println(p[k]+" ");

    }

    }
}
