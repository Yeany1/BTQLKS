package entity;

import java.math.BigDecimal;
import java.util.Objects;

public class DichVu {
	private String maDV, tenDV;
	private BigDecimal giaDV;

	public DichVu(String maDV, String tenDV, BigDecimal giaDV) {
		super();
		this.maDV = maDV;
		this.tenDV = tenDV;
		this.giaDV = giaDV;
	}

	public String getMaDV() {
		return maDV;
	}

	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}

	public String getTenDV() {
		return tenDV;
	}

	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}

	public BigDecimal getGiaDV() {
		return giaDV;
	}

	public void setGiaDV(BigDecimal giaDV) {
		this.giaDV = giaDV;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maDV);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DichVu other = (DichVu) obj;
		return Objects.equals(maDV, other.maDV);
	}

}
