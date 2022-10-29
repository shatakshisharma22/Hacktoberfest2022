class BookMyShow {
    int seats[][];
    int noOfSeats;

    public BookMyShow(int n, int m) {
        seats = new int[n][m];
        noOfSeats = m;
    }

   

    public int[] gather(int k, int maxRow) {

        for (int i = 0; i <= maxRow; i++) {
            if (seats[i].length >= k) {
                int ar[] = new int[2];
                ar[0] = i;
                ar[1] = noOfSeats - seats[i].length;
                int size = seats[i].length - k;
                seats[i] = new int[size];
                return ar;
            }
        }
        int ar[] = new int[0];
        return ar;
    }

    public boolean scatter(int k, int maxRow) {
        int availSeats = 0;
        for (int i = 0; i <= maxRow; i++) {
            availSeats += seats[i].length;
        }
   
        if (availSeats >= k) {
            for (int i = 0; i < seats.length; i++) {
                if (k == 0)
                    return true;
                if (seats[i].length >= k) {
                    seats[i] = new int[seats[i].length - k];
                    return true;
                } else {
                    k -= seats[i].length;
                    seats[i] = new int[0];
                }
            }
            return true;

        } else
            return false;
    }
}
