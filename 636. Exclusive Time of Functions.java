/**
 * 用栈把过程模拟出来即可
 * 注意两点。第一，当前func出栈时，要同时更新出栈后新栈顶的开始执行时间,
 * 否则会将其它func的执行时间也算进来；
 * 第二，题目中start和end的时间点有区别。比如时间点5，如果是start指的是
 * 4刚结束5刚开始那一点，如果是end则是指5刚结束6刚开始的那一点。
 */
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] rst = new int[n];
        Arrays.fill(rst, 0);
        Stack<Func> stack = new Stack<>();
        for (String log : logs) {
            String[] infos = log.split(":");
            int timePoint = Integer.parseInt(infos[2]);
            if ("start".equals(infos[1])) {
                Func func = new Func();
                func.id = Integer.parseInt(infos[0]);
                func.start = timePoint;
                if (!stack.isEmpty()) {
                    Func curF = stack.peek();
                    rst[curF.id] += timePoint - curF.start;
                }
                stack.push(func);
            } else { // end
                Func curF = stack.pop();
                rst[curF.id] += timePoint + 1 - curF.start;
                if (!stack.isEmpty()) {
                    Func nextF = stack.peek();
                    nextF.start = timePoint + 1;
                }
            }
        }
        return rst;
    }
    
    class Func {
        public int id;
        // start time of processing
        public int start;
        
        public Func() {
            
        }
        
    }
}