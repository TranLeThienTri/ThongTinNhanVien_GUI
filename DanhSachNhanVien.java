package tranLeThienTri_21001781;

import java.util.ArrayList;
import java.util.List;

public class DanhSachNhanVien {
	List<NhanVien> ds = new ArrayList<NhanVien>();
	
	
	// them
	public boolean themNv(NhanVien nv) {
		if(ds.contains(nv))
			return false;
		ds.add(nv);
		return true;
	}
	
	// xoas nhan vien theo vi tri
	public boolean xoaTheoViTri(int vt) {
		if(vt >=0 && vt<=ds.size()-1) {
			ds.remove(vt);
			return true;
		}
		return false;
	}
	
	
	//xoa theo ma
	public boolean xoaTheoMa(String ma) {
		for (NhanVien nhanVien : ds) {
			if(nhanVien.getMaNV().equalsIgnoreCase(ma)) {
				ds.remove(nhanVien);
				return true;				
			}
		}return false;
	}
	
	
	//tim theo ma
	public int timKiemNv(String ma) {
		for (int i = 0; i < ds.size(); i++) {
			if(ds.get(i).getMaNV().equalsIgnoreCase(ma))
				return i;
		}
		return -1;
	}
	
	
	
}
