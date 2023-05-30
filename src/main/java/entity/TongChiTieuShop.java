package entity;

public class TongChiTieuShop {
	private int sellID;
	private double TongBanHang;

	public TongChiTieuShop() {
		super();
	}

	public TongChiTieuShop(int sellID, double tongBanHang) {
		super();
		this.sellID = sellID;
		TongBanHang = tongBanHang;
	}

	public int getSellID() {
		return sellID;
	}

	public void setSellID(int sellID) {
		this.sellID = sellID;
	}

	public double getTongBanHang() {
		return TongBanHang;
	}

	public void setTongBanHang(double tongBanHang) {
		TongBanHang = tongBanHang;
	}

	@Override
	public String toString() {
		return "TongChiTieuShop [sellID=" + sellID + ", TongBanHang=" + TongBanHang + "]";
	}

}
