package other;

/**
 * @Author: Wenhang Chen
 * @Description:有一个特殊的正方形房间，每面墙上都有一面镜子。除西南角以外，每个角落都放有一个接受器，编号为 0， 1，以及 2。 正方形房间的墙壁长度为 p，一束激光从西南角射出，首先会与东墙相遇，入射点到接收器 0 的距离为 q 。
 * <p>
 * 返回光线最先遇到的接收器的编号（保证光线最终会遇到一个接收器）。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入： p = 2, q = 1
 * 输出： 2
 * 解释： 这条光线在第一次被反射回左边的墙时就遇到了接收器 2 。
 * @Date: Created in 21:14 6/23/2020
 * @Modified by:
 */
public class SpecularReflection {
    double EPS = 1e-6;

    public int mirrorReflection(int p, int q) {
        double x = 0, y = 0;
        double rx = p, ry = q;

        // While it hasn't reached a receptor,...
        while (!(close(x, p) && (close(y, 0) || close(y, p))
                || close(x, 0) && close(y, p))) {
            // Want smallest t so that some x + rx, y + ry is 0 or p
            // x + rxt = 0, then t = -x/rx etc.
            double t = 1e9;
            if ((-x / rx) > EPS) t = Math.min(t, -x / rx);
            if ((-y / ry) > EPS) t = Math.min(t, -y / ry);
            if (((p - x) / rx) > EPS) t = Math.min(t, (p - x) / rx);
            if (((p - y) / ry) > EPS) t = Math.min(t, (p - y) / ry);

            x += rx * t;
            y += ry * t;

            if (close(x, p) || close(x, 0)) rx *= -1;
            if (close(y, p) || close(y, 0)) ry *= -1;
        }

        if (close(x, p) && close(y, p)) return 1;
        return close(x, p) ? 0 : 2;
    }

    public boolean close(double x, double y) {
        return Math.abs(x - y) < EPS;
    }
}























