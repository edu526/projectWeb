create table empleado(
	codEmp	 char(5) primary key,
	nomEmp 	varchar(50),
	apeEmp 	varchar(50),
	dirEmp 	varchar(100),
	dniEmp 	char(8) ,
	licCon 		varchar(50),
	telEmp 	varchar(20) ,
	seguroEmp 	varchar(50),
	emailEmp 	varchar(50) 
);

create table vehiculo(
	codVeh 	char(5) primary key,
	NFlota 		varchar(2),
	matricuVeh 	varchar(30),
	modelVeh	varchar(50) ,
	motorVeh	varchar(50),
	serieVeh 	varchar(30),
	anioVeh 	varchar(10),
	estadVeh 	varchar(20) ,
	tipoVeh 	varchar(30) ,
	precVeh 	double,
	codEmp 	char(5) references empleado
);

create table ruta(
	codRut 	char(5) primary key,
	paradAut 	varchar(20),
	precRut 	double 
);

create table alquiler (
	numAlq 	char(5) primary key,
	fecAlq 		varchar(10) ,
	estadAlq 	varchar(20),
	codEmp 	char(5) references empleado,
	codVeh 	char(5) references vehiculo,
	tot 		double,
	hora 		varchar(20),
	desct               double
);

create table linea_alquiler(
	numAlq 	char(5) references alquiler ,
	codRut 	char(5) references ruta,
	dia		varchar(20),
	primary key (numAlq,codRut,dia)
);
