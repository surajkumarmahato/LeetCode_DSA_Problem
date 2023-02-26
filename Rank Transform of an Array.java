/*
Rank Transform of an Array
Given an array of integers arr, replace each element with its rank.
The rank represents how large the element is. The rank has the following rules:
Rank is an integer starting from 1.
The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
Rank should be as small as possible.
*/

class Solution 
{
    public int[] arrayRankTransform(int[] arr) 
    {
        int n= arr.length;
		PriorityQueue<Integer> pq= new PriorityQueue<>();
		for(int i=0; i<n; i++)
		   pq.add(arr[i]);
		HashMap<Integer,Integer> map= new HashMap<>();
		int count=1;
		while(!pq.isEmpty())
		{
			int val= pq.remove();
			if(!map.containsKey(val))
			{
				map.put(val,count);
				count++;
			} 
		}
		for(int i=0; i<n; i++)
		{
			arr[i]=map.get(arr[i]);
		}
		return arr;
    }
}