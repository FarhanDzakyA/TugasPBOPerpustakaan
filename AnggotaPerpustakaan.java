package jinpaidi;


import java.util.ArrayList;
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
class AnggotaPerpustakaan {
    private String nama;
    private int nomorAnggota;
    private String alamat;
    private ArrayList<TransaksiPeminjaman> historiPeminjaman;

    public AnggotaPerpustakaan(String nama, int nomorAnggota, String alamat) {
        this.nama = nama;
        this.nomorAnggota = nomorAnggota;
        this.alamat = alamat;
        this.historiPeminjaman = new ArrayList<TransaksiPeminjaman>();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getNomorAnggota() {
        return nomorAnggota;
    }

    public void setNomorAnggota(int nomorAnggota) {
        this.nomorAnggota = nomorAnggota;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public ArrayList<TransaksiPeminjaman> getHistoriPeminjaman() {
        return historiPeminjaman;
    }

    public void setHistoriPeminjaman(ArrayList<TransaksiPeminjaman> historiPeminjaman) {
        this.historiPeminjaman = historiPeminjaman;
    }
    
    public boolean cariBuku(Admin admin, String judul) {
        for(Buku x : admin.getDaftarBuku()) {
            if(judul.equals(x.getJudul())) {
                return true;
            }
        }
        
        return false;
    }
    
    public void addHistori(TransaksiPeminjaman tp) {
        historiPeminjaman.add(tp);
    }
    
    public boolean pinjamBuku(TransaksiPeminjaman tp){
        if(tp.getBuku().isStatusKetersediaan()){
            tp.getBuku().setStatusKetersediaan(false);
            tp.setStatusPengembalian(false);
            addHistori(tp);
            return true;
        }
        return false;
    }
    
    public boolean balikkanBuku(TransaksiPengembalian tp){
        TransaksiPeminjaman pinjam = tp.getTransaksiPeminjaman();
        if(historiPeminjaman.contains(pinjam)&& pinjam.getTanggalPeminjaman().isBefore(pinjam.getTanggalPengembalian())){
            pinjam.getBuku().setStatusKetersediaan(true);
            pinjam.setStatusPengembalian(true);
            return true;
        }
        return false;
    }
    
    public void lihatBuku(Admin admin){
        System.out.println("Daftar Buku ");
        System.out.println("=======================================");
        for(Buku buku : admin.getDaftarBuku()) {
            System.out.println("Judul\t\t: " + buku.getJudul());
            System.out.println("Pengarang\t: " + buku.getPengarang());
            System.out.println("Genre\t\t: " + buku.getKategori());
            System.out.println("ISBN\t\t: " + buku.getNomorISBN());
            System.out.println("Status\t\t: " + (buku.isStatusKetersediaan() == true ? "Buku Tersedia" : "Buku Tidak Tersedia"));
            System.out.println("=======================================");
        }
    }
}
