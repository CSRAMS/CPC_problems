#include <cstdio>

#define SIZE 101
#define MIN -127
#define max(a, b) ((a) > (b) ? (a) : (b))

int inputArr[SIZE][SIZE] = {0};
int sums[SIZE][SIZE] = {0}; // dp array

int getMaxSum(int n) {
    // Fill dynamic programming tabulation array with sums:
    // sum at a dp array cell = input_num + left_dp_num + top_dp_num - left_top_dp_num
    // We subtract left_top_dp_num from the sum to remove
    // the intersection of left_dp_num and top_dp_num.
    // (A U B) = A + B - (A ∩ B)
    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= n; j++)
            sums[i][j] = inputArr[i-1][j-1] + sums[i][j-1] + sums[i-1][j] - sums[i-1][j-1];

    // Check sums of all possible subarrays (brute-force).
    // Using the sums dp array, we can calculate the sum of each subarray in O(1) time.
    // We use 2 points for subindexing the sums array: (x,y) and (x2, y2).
    int maxSubarrSum = MIN;
    for (int x2 = 0; x2 <= n; x2++) {
        for (int y2 = 0; y2 <= n; y2++) {
            for (int x = 0; x <= x2; x++) {
                for (int y = 0; y <= y2; y++) {
                    int subarrSum = (sums[x2][y2] - sums[x][y2]) + (sums[x][y] - sums[x2][y]);
                    maxSubarrSum = max(maxSubarrSum, subarrSum);
                }
            }
        }
    }

    return maxSubarrSum;
}

int main() {
    int n, num;
    scanf("%d", &n);
    if (n > 0) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                scanf("%d", &num);
                inputArr[i][j] = num;
            }
        }
        printf("%d\n", getMaxSum(n));
    } else {
        printf("0\n");
    }

    return 0;
}