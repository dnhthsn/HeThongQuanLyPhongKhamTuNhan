create table if not exists bacsi (
	mabs int NOT NULL AUTO_INCREMENT,
    cmt nvarchar(50) not null,
    tenbs nvarchar(50) not null,
    ngaysinh nvarchar(50) not null,
    diachi nvarchar(50) not null,
    bacnghe nvarchar(50) not null,
    thamnien nvarchar(50) not null,
    trinhdodaotao nvarchar(50) not null,
    chuyenmon nvarchar(50) not null,
	PRIMARY KEY (mabs)
);
create table if not exists yta (
	mayt int NOT NULL AUTO_INCREMENT,
    cmt nvarchar(50) not null,
    tenyt nvarchar(50) not null,
    trinhdo nvarchar(50) not null,
    thamnien nvarchar(50) not null,
    ngaysinh nvarchar(50) not null,
    diachi nvarchar(50) not null,
    sdt nvarchar(50) not null,
	PRIMARY KEY (mayt)
);

create table if not exists benh (
    tenbenh nvarchar(50) not null,
    mota nvarchar(50) not null,
    loaibenh nvarchar(50) not null,
    
	PRIMARY KEY (tenbenh)
);

create table if not exists thuoc (
    tenthuoc nvarchar(50) not null,
    giatien float(10) not null,
    loai nvarchar(50) not null,
    
	PRIMARY KEY (tenthuoc)
);

create table if not exists benhnhan (
	mabn int NOT NULL AUTO_INCREMENT,
    tenbn nvarchar(50) not null,
    cmt nvarchar(50) not null,
    ngaysinh nvarchar(50) not null,
    diachi nvarchar(50) not null,
    sdt nvarchar(50) not null, 
	PRIMARY KEY (mabn)
);

create table if not exists hosokham (
	mahsk int NOT NULL AUTO_INCREMENT,
    trangthai nvarchar(50) not null,
    mabs int not null,
    mayt int not null,
    mabn int not null,
    ngayvaovien nvarchar(50),
    ngayravien nvarchar(50),
    tenbenh nvarchar(50),
    tonggiatien float(10),
    malankham int,
    
	PRIMARY KEY (mahsk),
	CONSTRAINT mabs FOREIGN KEY (mabs) REFERENCES bacsi (mabs) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT mayt FOREIGN KEY (mayt) REFERENCES yta (mayt) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT mabn FOREIGN KEY (mabn) REFERENCES benhnhan (mabn) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT tenbenh FOREIGN KEY (tenbenh) REFERENCES benh (tenbenh) ON DELETE CASCADE ON UPDATE CASCADE
);

create table if not exists hosokham_thuoc (
	ho_so_kham_mahsk int not null,
	thuoc_tenthuoc nvarchar(50) not null,
	FOREIGN KEY (ho_so_kham_mahsk) REFERENCES hosokham(mahsk) ON DELETE CASCADE ON UPDATE CASCADE,
  	FOREIGN KEY (thuoc_tenthuoc) REFERENCES thuoc(tenthuoc) ON DELETE CASCADE ON UPDATE CASCADE
)