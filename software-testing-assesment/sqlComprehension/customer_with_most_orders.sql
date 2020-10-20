select contact_name
from customers
where customer_id in (select customer_id
                      from (
                               select count(1), customer_id
                               from orders
                               group by customer_id
                               order by 1 desc
                               limit 1) as foo)