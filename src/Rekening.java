import java.util.Locale;

public abstract class Rekening {
    private String nomor;
    private String pemilik;
    protected int saldo;

    public Rekening(String nomor, String pemilik, int saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    public String getNomor() {
        return nomor;
    }

    public String getPemilik() {
        return pemilik;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setor(int jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
        }
    }

    public boolean tarik(int jumlah) {
        if (jumlah > 0 && jumlah <= saldo) {
            saldo -= jumlah;
            return true;
        }
        return false;
    }

    // Setiap jenis rekening wajib menentukan biaya admin bulanannya sendiri.
    public abstract int biayaAdminBulanan();

    // Memanggil versi biayaAdminBulanan() milik object-nya (polimorfisme).
    public int potongBiayaAdmin() {
        int biaya = biayaAdminBulanan();
        saldo -= biaya;
        return biaya;
    }

    public void tampilkanInfo() {
        System.out.printf("%s | %-6s | %12s%n", nomor, pemilik, formatRupiah(saldo));
    }

    public static String formatRupiah(int angka) {
        return "Rp" + String.format(Locale.GERMANY, "%,d", angka);
    }
}