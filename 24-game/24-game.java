class Solution {
    public boolean judgePoint24(int[] nums) {
       	if (nums == null || nums.length == 0) return false;
	int n = nums.length;

	double[] a = new double[n];
	for (int i = 0; i < n; i++)
		a[i] = (double) nums[i];

	return helper(a);
}

private boolean helper(double[] a) {
	if (a.length == 1) return Math.abs(a[0] -  24) < 0.001;

	for (int i = 0; i < a.length; i++) {
		for (int j = i + 1; j < a.length; j++) {

			double[] b = new double[a.length - 1];

			for (int k = 0, idx = 0; k < a.length; k++) {
				if (k == i || k == j) continue;
				b[idx++] = a[k];
			}
			for (double c : compute(a[i], a[j])) {
				b[b.length - 1] = c;
				if (helper(b)) return true;
			}
		}
	}
	return false;
}
private double[] compute(double x, double y) {
	return new double[] {x + y, x - y, y - x, x * y, x / y, y / x};
}
}