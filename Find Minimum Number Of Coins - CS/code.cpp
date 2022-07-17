int findMinimumCoins(int amount) 
{
    int arr[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
    int size = sizeof(arr) / sizeof(int);
    int i = size - 1, count = 0;
    while(amount > 0) {
        if(amount >= arr[i]) {
            int div = amount / arr[i];
            amount %= arr[i];
            count += div;
        }
        
        i--;
    }
    
    return count;
}
