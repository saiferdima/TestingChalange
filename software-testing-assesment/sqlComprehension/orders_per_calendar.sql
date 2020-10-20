select extract(
               year from orders.order_date) as year,
       count(1)                             as orders_number
from orders
where order_date >= '1996-01-01'
group by year
