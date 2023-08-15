// Introduction to 2-D Arrays | Data Structures and Algorithms in JAVA

// 2D Array
// 2D array can be defined as an array of arrays. The 2D array 
// is organized as matrices which can be represented as the collection of rows and columns.

// However, 2D arrays are created to implement a relational database look alike data structure. It provides ease of 
// holding bulk of data at once which can be passed to any number of functions wherever required.
int arr[max_rows][max_columns];     declaration

// access

int x = a[i][j];   

// We can assign each cell of a 2D array to 0 by using the following code:

for ( int i=0; i<n ;i++)  
{  
    for (int j=0; j<n; j++)   
    {  
        a[i][j] = 0;   
    }  
}  


// Initializing 2D Arrays

int arr[2][2] = {0,1,2,3};   


publicstaticvoid main(String[] args) {  
    int[][] arr = new int[3][3];  
    Scanner sc = new Scanner(System.in);  
    for (inti =0;i<3;i++)  
    {  
        for(intj=0;j<3;j++)  
        {  
            System.out.print("Enter Element");  
            arr[i][j]=sc.nextInt();  
            System.out.println();  
        }  
    }  
    System.out.println("Printing Elements...");  
    for(inti=0;i<3;i++)  
    {   
        System.out.println();  
        for(intj=0;j<3;j++)  
        {  
            System.out.print(arr[i][j]+"\t");  
        }  
    }  
}  


// Mapping 2D array to 1D array

//  2 D arrays exists from the user point of view.
//   2D arrays are created to implement a relational database table lookalike data structure, 
//   in computer memory, the storage technique for 2D array is similar to that of an one dimensional array.

// The size of a two dimensional array is equal to the multiplication of number of rows and the number 
// // of columns present in the array. 

// By Row Major Order
// If array is declared by a[m][n] where m is the number of rows while n is the number of columns, then address of
//  an element a[i][j] of the array stored in row major order is calculated as,



Address(a[i][j]) = B. A. + (i * n + j) * size   


// By Column major order
// If array is declared by a[m][n] where m is the number of rows while 
// n is the number of columns, then address of an element a[i][j] of the array stored in row major order is calculated as,

Address(a[i][j]) = ((j*m)+i)*Size + BA   



