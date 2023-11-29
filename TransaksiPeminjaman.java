package jinpaidi;


import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
class TransaksiPeminjaman {
    private AnggotaPerpustakaan anggota;
    private Buku buku;
    private int idPeminjaman;
    private LocalDate tanggalPeminjaman;
    private LocalDate tanggalPengembalian;
    private boolean statusPengembalian;

    public TransaksiPeminjaman(AnggotaPerpustakaan anggota, Buku buku, int idPeminjaman, LocalDate tanggalPeminjaman, LocalDate tanggalPengembalian) {
        this.anggota = anggota;
        this.buku = buku;
        this.idPeminjaman = idPeminjaman;
        this.tanggalPeminjaman = tanggalPeminjaman;
        this.tanggalPengembalian = tanggalPengembalian;
        this.statusPengembalian = false;
    }

    public boolean isStatusPengembalian() {
        return statusPengembalian;
    }

    public void setStatusPengembalian(boolean statusPengembalian) {
        this.statusPengembalian = statusPengembalian;
    }

    public AnggotaPerpustakaan getAnggota() {
        return anggota;
    }

    public void setAnggota(AnggotaPerpustakaan anggota) {
        this.anggota = anggota;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public int getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(int idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public LocalDate getTanggalPeminjaman() {
        return tanggalPeminjaman;
    }

    public void setTanggalPeminjaman(LocalDate tanggalPeminjaman) {
        this.tanggalPeminjaman = tanggalPeminjaman;
    }

    public LocalDate getTanggalPengembalian() {
        return tanggalPengembalian;
    }

    public void setTanggalPengembalian(LocalDate tanggalPengembalian) {
        this.tanggalPengembalian = tanggalPengembalian;
    }
    
    
}
