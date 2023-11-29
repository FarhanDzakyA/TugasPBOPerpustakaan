/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jinpaidi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Perpustakaan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Untuk membaca input dati User
        Scanner input = new Scanner(System.in);
        
        // Membuat objek dari class Notifikasi
        Notifikasi peringatan = new Notifikasi(1);
        Notifikasi pemberitahuan = new Notifikasi(2);
        
        // Membuat objek dari class Admin
        Admin admin1 = new Admin(01, "Bambang Sugeni");
        Admin admin2 = new Admin(02, "Ade Irawan");
        
        // Membuat objek dari class AnggotaPerpustakaan
        AnggotaPerpustakaan anggota1 = new AnggotaPerpustakaan("Abdul Bari", 01, "Kp. Baru");
        AnggotaPerpustakaan anggota2 = new AnggotaPerpustakaan("Abdul Adhim", 02, "Pagar Alam");
        
        // Membuat objek dari class Buku
        Buku buku1 = new Buku("Cinta Brontosaurus", "Raditya Dika", "978-979-780-896-9", true, "Romance Comedy");
        Buku buku2 = new Buku("Pergi", "Tere Liye", "978-602-5734-05-2", true, "Romance");
        Buku buku3 = new Buku("Harry Potter and The Cursed Child", "J.K. Rowling", "978-602-03-8620-1", true, "Fantasy");
        
        // Menginisialisasi waktu untuk waktu peminjaman dan waktu pengembalian
        LocalDate tanggalPeminjaman = LocalDate.now();
        LocalDate tanggalPengembalian = LocalDate.parse("2023-12-20");
        
        // Membuat objek dari class TransaksiPeminjaman dan TransaksiPengembalian
        TransaksiPeminjaman peminjaman = new TransaksiPeminjaman(anggota1, buku1, 01, tanggalPeminjaman, tanggalPengembalian);
        TransaksiPengembalian pengembalian = new TransaksiPengembalian(peminjaman);
        
        // Admin melakukan penambahan buku dan anggota dan memberikan notif buku telah ditambahkan
        admin1.addBuku(buku1); pemberitahuan.notif();
        admin1.addBuku(buku2); pemberitahuan.notif();
        admin1.addBuku(buku3); pemberitahuan.notif();
        admin2.addAnggota(anggota1);
        admin2.addAnggota(anggota2);
        
        // Anggota melakukan pencarian buku
        System.out.println("");
        System.out.print("Masukkan judul yang akan dicari : ");
        String judul = input.nextLine();
        
        if(anggota1.cariBuku(admin2, judul)) {
            System.out.println("Buku dengan judul " + judul + " ditemukan");
            System.out.println("");
        } else {
            System.out.println("Buku dengan judul " + judul + " tidak ditemukan");
            System.out.println("");
        }
        
        // Anggota melihat daftar buku yang ada
        anggota2.lihatBuku(admin2);
        
        // Anggota melakukan peminjaman buku
        anggota1.pinjamBuku(peminjaman);
        
        // Admin melihat Laporan Aktivitas sebelum anggota melakukan pengembalian
        System.out.println("");
        System.out.println("Sebelum anggota melakukan pengembalian");
        admin1.laporanAktivitas();
        
        // Anggota melakukan pengembalian buku
        anggota1.balikkanBuku(pengembalian);
        
        // Admin melihat Laporan Aktivitas setelah anggota melakukan pengembalian
        System.out.println("");
        System.out.println("Setelah anggota melakukan pengembalian");
        admin1.laporanAktivitas();
    }
    
    
}
