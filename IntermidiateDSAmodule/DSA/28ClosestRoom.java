// 1847. Closest Room
// Hard
// 464
// 19
// Companies
// There is a hotel with n rooms. The rooms are represented by a 2D integer array rooms where rooms[i] = [roomIdi, sizei] denotes that there is a room with room number roomIdi and size equal to sizei. Each roomIdi is guaranteed to be unique.

// You are also given k queries in a 2D array queries where queries[j] = [preferredj, minSizej]. The answer to the jth query is the room number id of a room such that:

// The room has a size of at least minSizej, and
// abs(id - preferredj) is minimized, where abs(x) is the absolute value of x.
// If there is a tie in the absolute difference, then use the room with the smallest such id. If there is no such room, the answer is -1.

// Return an array answer of length k where answer[j] contains the answer to the jth query.

 

// Example 1:

// Input: rooms = [[2,2],[1,2],[3,2]], queries = [[3,1],[3,3],[5,2]]
// Output: [3,-1,3]
// Explanation: The answers to the queries are as follows:
// Query = [3,1]: Room number 3 is the closest as abs(3 - 3) = 0, and its size of 2 is at least 1. The answer is 3.
// Query = [3,3]: There are no rooms with a size of at least 3, so the answer is -1.
// Query = [5,2]: Room number 3 is the closest as abs(3 - 5) = 2, and its size of 2 is at least 2. The answer is 3.
// Example 2:

// Input: rooms = [[1,4],[2,3],[3,5],[4,1],[5,2]], queries = [[2,3],[2,4],[2,5]]
// Output: [2,1,3]
// Explanation: The answers to the queries are as follows:
// Query = [2,3]: Room number 2 is the closest as abs(2 - 2) = 0, and its size of 3 is at least 3. The answer is 2.
// Query = [2,4]: Room numbers 1 and 3 both have sizes of at least 4. The answer is 1 since it is smaller.
// Query = [2,5]: Room number 3 is the only room with a size of at least 5. The answer is 3.

teps to follow:

Sort the rooms array on the basis of capacity . So that we can do binary search and got the first room index which have size greater than minsize for particular query.
If we have found the start index . we know that array is sorted so all size in right are going to be greater than size So iterate and find the roomId where Math.abs(room_id-prefrence) is minimum.
Have this point in mind if two rooms have value for Math.abs(room_id-preference) we have to select room with smaller id.
Go through code you will understand rest things.
CODE:


class Solution {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        Arrays.sort(rooms,new Pair());
        int[] ans=new int[queries.length];
        
        for(int i=0;i<ans.length;i++){
            int size=queries[i][1];
            int p=queries[i][0];
            
            int start=binarySearch(rooms,size);
            if(start==-1){
                ans[i]=-1;
                continue;
            }
            
            int index=find(rooms,start,p);
            ans[i]=rooms[index][0];
        }
        return ans;
    }
    
    private int find(int[][] rooms,int start,int p){
        int ans=start;
        int min=Math.abs(rooms[start][0]-p);
        for(int i=start+1;i<rooms.length;i++){
            int diff=Math.abs(rooms[i][0]-p);
            if(diff<min){
                min=diff;
                ans=i;
            }else if(diff==min){
                if(rooms[i][0]<rooms[ans][0]){
                    ans=i;
                }
            }
        }
        return ans;
    }
    
    private int binarySearch(int[][] rooms,int size){
        int lo=0 , hi=rooms.length-1;
        int ans=-1;
        while(lo<=hi){
            int mid=lo + (hi-lo)/2;
            
            if(rooms[mid][1]<size){
                lo=mid+1;
            }else{
                ans=mid;
                hi=mid-1;
            }
        }
        return ans;
    }
    
    public class Pair implements Comparator<int[]>{
        public int compare(int[] one,int[] two){
            return one[1]-two[1];
        }
    }
}