/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baiktra;

/**
 *
 * @author NomNom
 */
public class Bank {
    double[] account;
        public Bank(int n, double iniBalance){
            account = new double[n];
            for(int i = 0; i < account.length; i++){
                account[i] = iniBalance;
            }
        }
        
        public int size(){
            return account.length;
        }
        
        public synchronized double getTotalBalane(){
            double total = 0;
            for (int i = 0; i < account.length; i++){
                total+=account[i];
            }
            return total;
        }
        
        public synchronized void transfer(int from, int to, double amount){
            try{
                while(account[from]<amount)
                    {
                        System.out.println(Thread.currentThread().getName()+"đợi đủ tiền");
                        wait();
                        System.out.println(Thread.currentThread().getName()+"tiếp tục giao dịch");
                    }
                account[from] -= amount;
                account[to] += amount;
                System.out.println("Chuyển " + amount + " Từ account " + from + " sang account " + to);
                System.out.println("Tổng tiền của các account: " + getTotalBalane());
            }catch(InterruptedException ex){
                InternalError("Giao dịch bị gián đoạn");
            }
        }

    private void InternalError(String giao_dịch_bị_gián_đoạn) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
