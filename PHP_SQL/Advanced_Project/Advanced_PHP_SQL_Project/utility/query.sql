select c.id, c.company_name as company_name, i.symbol, i.issuerName, i.sharesValue
from company_name c
inner join investments i
on c.id = i.companyId
limit 10;



create view investment_summary_vw as 
select c.id
    , c.company_name as companyName
    , count(c.id) as count
    , avg(i.sharesValue) as average
    , sum(i.sharesValue) as total
    , max(i.sharesValue) as maximum
from company_name c
inner join investments i 
on c.id = i.companyId 
group by c.id, c.company_name
limit 50;
