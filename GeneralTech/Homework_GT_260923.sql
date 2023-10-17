-- 1) Output all users with balance over 100 EUR

db.users.find(
{ balance: {$gt: 100}}
)


-- 2) Display names of unblocked users with balance from 10 to 1000 EUR

db.users.find({
$and: [
  {balance: { $gt: 10, $lt: 1000}},
  {is_blocked: {$ne: true}}
  ]
})


-- 3) Reset the balance of blocked non-France users to zero

db.users.updateMany(
{is_blocked: true, country: {$ne: "France" }},
{$set: {balance: 0}}
)


-- 4) Decrease the balance of user 5 by 3.5%

db.users.updateOne(
{_id: 5}, 
{$mul: { balance: 0.965 }}
)


-- 5) Increase the balance of unblocked users by 0.5%

db.users.updateMany(
{is_blocked: false}, 
{$mul: {balance: 1.05}}
)
