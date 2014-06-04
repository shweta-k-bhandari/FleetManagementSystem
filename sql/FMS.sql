create database FMS;

use fms;

show tables;

drop table if exists ClientInfo;

create table ClientInfo
(
  ClientName VARCHAR(45) NOT NULL ,
  ClientAddress VARCHAR(500) NULL ,
  ClientPhoneNumber INT NULL ,
  LastTradingDate DATE NULL ,
  PRIMARY KEY (`ClientName`) 
);
  
/*insert into ClientDetails values ('Shweta', '506 ushanagar', 90213, '2000-05-05');*/

select * from ClientInfo;

commit;

use fms;

drop table if exists VehicalInfo;

create table VehicalInfo
(
    VehicalUniqueId numeric(5),
    VehicalRegistrationNumber numeric(5) not null,
    VehicalModelName varchar(45),
    VehicalInsuranceExpiryDate date,
    VehicalStatus varchar(45),
    VehicalLocation varchar(50),
    VehicalKilometerReading numeric(5),
    primary key (VehicalRegistrationNumber)
);

insert into VehicalInfo(VehicalUniqueId, VehicalRegistrationNumber, VehicalModelName, VehicalInsuranceExpiryDate, VehicalStatus, VehicalLocation, VehicalKilometerReading) values(1,5678,'Volvo', '2014-05-05', 'Available', 'Parking', 300);

insert into VehicalInfo(VehicalUniqueId, VehicalRegistrationNumber, VehicalModelName, VehicalInsuranceExpiryDate, VehicalStatus, VehicalLocation, VehicalKilometerReading) values(2,1234,'Mercedes', '2014-06-06', 'Available', 'Parking', 500);
insert into VehicalInfo(VehicalUniqueId, VehicalRegistrationNumber, VehicalModelName, VehicalInsuranceExpiryDate, VehicalStatus, VehicalLocation, VehicalKilometerReading) values(3,2345,'Volvo', '2014-03-03', 'UnAvailable', 'Pune', 100);
insert into VehicalInfo(VehicalUniqueId, VehicalRegistrationNumber, VehicalModelName, VehicalInsuranceExpiryDate, VehicalStatus, VehicalLocation, VehicalKilometerReading) values(4,3456,'Mercedes', '2014-04-04', 'Available', 'Parking', 200);

select * from VehicalInfo where VehicalStatus='Available';

commit;

use fms;

drop table if exists DriverInfo;

create table DriverInfo
(
    DriverName varchar(50),
    DriverIdProof varchar(30),
    DriverIdNumber varchar(45) not null,
    DriverAddress varchar(500),
    DriverStatus varchar(45),
    DriverPhoneNumber double,
    primary key(DriverIdNumber)
);

insert into DriverInfo(DriverName, DriverIdProof, DriverIdNumber, DriverAddress, DriverStatus, DriverPhoneNumber) values('Shamu', 'Pancard', 'AMP23456', 'Indore', 'On leave', 9424542424);

insert into DriverInfo(DriverName, DriverIdProof, DriverIdNumber, DriverAddress, DriverStatus, DriverPhoneNumber) values('Ramu', 'Pancard', 'QAZ23456', 'Pune', 'Available', 9424502002);
insert into DriverInfo(DriverName, DriverIdProof, DriverIdNumber, DriverAddress, DriverStatus, DriverPhoneNumber) values('Shamu', 'Pancard', 'MPS23456', 'Kolkata', 'Available', 942455678);

select DriverName from DriverInfo where DriverStatus='Available';

commit;

use fms;

drop table if exists OrderInfo;

create table OrderInfo
(
    OrderNumber int not null,
    ClientName varchar(45) not null,
    OrderDate date not null,
    BillingDate date not null,
    DeliveryDate date not null,
    DestinationAddress varchar(500) not null,
    primary key(OrderNumber)
);

/*insert into OrderInfo(OrderNumber, ClientName, OrderDate, BillingDate, DeliveryDate, DestinationAddress) values(5454, 'xyz corp', '2000-02-02', '2000-02-04', '2000-03-04', 'zxy qwqw India');*/

select * from OrderInfo;

commit;

use fms;

drop table if exists ConsignmentReport;

create table ConsignmentReport
(
    DepartureDate date not null,
    ArrivalDate date not null,
    DriverName varchar(45) not null,
    VehicalRegistrationNumber int not null,
    SourceLocation varchar(500) not null,
    DestinationLocation varchar(500) not null,
    
);

/*insert into ConsignmentReport(OrderNumber, ClientName, OrderDate, BillingDate, DeliveryDate, DestinationAddress) values(5454, 'xyz corp', '2000-02-02', '2000-02-04', '2000-03-04', 'zxy qwqw India');*/

select * from ConsignmentReport;

commit;



