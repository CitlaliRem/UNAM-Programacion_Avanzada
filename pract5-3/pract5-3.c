#include <stdio.h>

int main(){

	int i, j ,k;

	float A[3][3] = {{1,2,3},{-2,-4,8},{3,1,2}};
	float B[3] ={ 2.4,6.4,7.6};
	float cte;

	for(i=0; i<3;i++){
	    for(j=i+1; j<3; j++){
	    	if (A[i][i]==0){
				i++;
			}
			cte = A[j][i]/A[i][i];
		
			for(k=i; k<3; k++){
				A[j][k] = A[j][k] - cte * A[i][k];
			}
			B[j] = B[j] - cte * B[i];
	    }
	}

	for(i=0; i<3; i++){
		for(j=0; j<3; j++){
			printf("%0.2f\t", A[i][j]);
		}
		printf("| %0.2f\n", B[i]);
	}
	return 0;
}
