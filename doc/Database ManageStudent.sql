create database ManageStudent
go

use ManageStudent
go



create table Classes(
	idClass int primary key identity,
	nameClass nvarchar(100),
	schoolYear int,
)


create table Students(
	idStudent int identity primary key,
	nameStudent nvarchar(100),
	BirthDate date,
	imagesStudent nvarchar(500),
	address nvarchar(200),
	gender nvarchar(10),
	idClass int foreign key references Classes(idClass)
)


create table Subjects(
	idSubject int identity primary key,
	nameSubject nvarchar(100),

)

create table Points(
	idStudent int references Students(idStudent),
	idSubject int references Subjects(idSubject),
	point int 
	primary key(idStudent,idSubject)
)

create table Teachers(
	idTeacher int identity primary key,
	nameTeacher nvarchar(50),
	imagesTeacher nvarchar(500),
	idSubject int references Subjects(idSubject),
	idClass int references Classes(idClass),
	address nvarchar(100),
	phone int 
)