
drop table  investments;

CREATE TABLE investments (
    id varchar(5),
    companyId varchar(5),
    symbol varchar(10),
    issuerName varchar(30),
    cl varchar(30),
    cusip varchar(10),
    sharesValue dec(18,7),
    percentage dec(18,7),
    shares dec(18,7),
    PRIMARY KEY (ID) 
);


INSERT INTO investments (id, companyId, symbol, issuerName, cl, cusip, sharesValue, percentage,shares)
VALUES ('$id', '$companyId', '$symbol', '$issuerName', '$cl', '$cusip', $sharesValue, $percentage,$shares);