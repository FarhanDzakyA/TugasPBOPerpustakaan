package jinpaidi;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class Admin {
    private int idAdmin;
    private String namaAdmin;
    private static ArrayList<AnggotaPerpustakaan> daftarAnggota = new ArrayList<>();
    private static ArrayList<Buku> daftarBuku = new ArrayList<>();

    public Admin(int idAdmin, String namaAdmin) {
        this.idAdmin = idAdmin;
        this.namaAdmin = namaAdmin;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNamaAdmin() {
        return namaAdmin;
    }

    public void setNamaAdmin(String namaAdmin) {
        this.namaAdmin = namaAdmin;
    }

    public ArrayList<AnggotaPerpustakaan> getDaftarAnggota() {
        return daftarAnggota;
    }

    public void setDaftarAnggota(ArrayList<AnggotaPerpustakaan> daftarAnggota) {
        this.daftarAnggota = daftarAnggota;
    }

    public ArrayList<Buku> getDaftarBuku() {
        return daftarBuku;
    }

    public void setDaftarBuku(ArrayList<Buku> daftarBuku) {
        this.daftarBuku = daftarBuku;
    }
    
    public void addAnggota(AnggotaPerpustakaan anggota){
        daftarAnggota.add(anggota);
    }
    
    public void addBuku(Buku buku){
        daftarBuku.add(buku);
    }
    
    public void laporanAktivitas(){
        System.out.println("Laporan Aktivitas");
        System.out.println("=========================");
        for(AnggotaPerpustakaan anggota : daftarAnggota){
            System.out.println("Nama Anggota \t\t: " + anggota.getNama());
            System.out.println("ID Anggota \t\t: " + anggota.getNomorAnggota());
            System.out.println("Rincian Peminjaman \t: ");
            for(TransaksiPeminjaman tp : anggota.getHistoriPeminjaman()){
                System.out.println("\tJudul \t\t\t: " + tp.getBuku().getJudul());
                System.out.println("\tTanggal Pinjam \t\t: " + tp.getTanggalPeminjaman());
                System.out.println("\tTanggal Pengembalian \t: " + tp.getTanggalPengembalian());
                System.out.println("\tStatus Pengembalian \t: " + (tp.isStatusPengembalian() == true ? "Sudah Dikembalikan" : "Belum Dikembalikan"));
                System.out.println("");
            }
        System.out.println("=========================");
        }
    }
}
