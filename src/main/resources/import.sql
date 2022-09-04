
insert into insurance_product values(1,'Our mission is to help you find best car insurance. Having Trouble finding cheap car coverage? Let us give you a push in the right direction.', 'Automobile');
insert into insurance_product values(2,'Buy the best Bike insurance Policies online!!!','Bike');
insert into insurance_product values(3,'This insurance product is related to Other vehicles','Other');

insert into policy values(101,'Auto liability coverage is mandatory in most of the state. Driver are legally required to purchase at least the minimum amount liability coverage set by state law', 'Liability Coverage',4000,1);
insert into policy values(102,'If you are involved in an accident with another vehicle, or if you hit an object such as a fence, collision coverage may help you', 'Collision Coverage',10000,1);
insert into policy values(103,'If you, your passengers or family members who are driving the insured vehicle are injured in an accident, medical payment coverage may help you', 'Medical Payments Coverage', 2000,1);
insert into policy values(104,'Comprehensive may help cover damage of your car from things like theft, fire, hail or vandalism', 'Comprehensive Coverage',4000,1);
insert into policy values(105,'if you are hit by a driver wjo does not have insurance uninsured motorist coverage may help pay for medical bills', 'Uninsured and underinsured motorist coverage',6000,1);

insert into policy values(106,'Comprehensive may help cover damage of your bike from things like theft, fire, hail or vandalism', 'Comprehensive bike Coverage',4000,2);
insert into policy values(107,'This is compulsory requirement to ride bike. You can buy this insurance in cheaper price', 'Third party Bike insurance', 4000,2);
insert into policy values(108,'The standalone own-damage bike insurance policy give coverage for own-damages sustained by insured bike due to an accident, theft, fire and natural disaster', 'Own-Damage Bike insurance', 10000,2);
insert into policy values(109,'If you, your passengers or family members who are driving the insured vehicle are injured in an accident, medical payment coverage may help you','Medical Payments Coverage', 2000,2);
insert into policy values(110,'if you are hit by a driver wjo does not have insurance uninsured motorist coverage may help pay for medical bills', 'Uninsured and underinsured motorist coverage', 6000,2);


insert into policy values(111,'This insurance coverage cover damage of bus due to accident, fire or any natural disaster', 'Bus Insurance coverage',4000,3);
insert into policy values(112,'This insurance coverage cover damage of vehicle due to accident, fire or any natural disaster', 'Three wheeler insurance',4000,3);

INSERT INTO payment(account_number, balance, credit_card_number, cvv) VALUES ('100002', 50000 , '10012021', 004);
