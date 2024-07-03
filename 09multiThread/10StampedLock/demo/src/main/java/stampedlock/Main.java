package stampedlock;
/*
 * StampedLock和ReadWriteLock相比，改进之处在于，读的过程中也允许获取写锁后写入，这样读取的数据就可能不一致，所以需要额外的代码来判断是否有写入，这种读锁被称之乐观锁；
 * 乐观锁：乐观的认为读的过程中大概率不会写入，并发效率高，但是如果有写导致读取的数据不一致，就需要能检测出来再读一遍；
 * 悲观锁：读的过程中拒绝有写入，也就是写入等待
 */

public class Main {
    public static void main(String[] args) {
    }
}