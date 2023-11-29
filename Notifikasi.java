/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jinpaidi;

/**
 *
 * @author USER
 */
public class Notifikasi {
    private int tipePesan;

    public Notifikasi(int tipePesan) {
        this.tipePesan = tipePesan;
    }

    public void setTipePesan(int tipePesan) {
        this.tipePesan = tipePesan;
    }

    public int getTipePesan() {
        return tipePesan;
    }
    
    public void notif() {
        if (this.tipePesan == 1) {
            System.out.println("Batas waktu pengembalian buku sudah dekat, harap segera mengembalikan buku!");
        } else if (this.tipePesan == 2) {
            System.out.println("Buku baru telah ditambahkan ke dalam perpustakaan");
        }
    }
}
