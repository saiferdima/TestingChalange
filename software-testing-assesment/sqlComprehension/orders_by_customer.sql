select count(1) as number_of_orders
from orders as O
         join customers as C
              on C.customer_id = O.customer_id
                  and C.company_name = 'Simons bistro'
         join shippers as S
              on S.shipper_id = O.ship_via
                  and S.company_name = 'United Package'