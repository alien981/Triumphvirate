# Triumphvirate

*Kristin Lin, Samantha Ngo, Despoina Sparakis*         
*APCS2 pd01*    
*Lab#03 -- RUVIP?*     
*2017-04-24*        

### Our Design

We begin by acknowledging our new customer and creating a ticket for them. Tickets are incremented by 1 each time, and hold the customer's name, ticket number, issue description, and priority. We determine priority based on a series of questions that are asked to the user after we record their new ticket number and their name. Based on their answers, we determine how important their issue seems to be. This eliminates the problem of users incorrectly assessing their issues or attempting to falsely prioritize their issue for the sake of their time over others. Once all the tickets are created, we begin to resolve issues, removing the highest priority ticket each time, resolving the issue by adding the solution to the ticket, and then removing the resolved ticket from the priority queue. For our enqueue and dequeue methods, we decided to enqueue and automatically place it in its correct order, making it O(logn) in the worst case scenario, and dequeue O(1) in worst case scenario. Although this appears a bit costly, it is better compared to an O(1) enqueue, and a O(n) dequeue in the worst case scenario.

### Our Embellishments

There are no significant embellishments, but Ticket class does have more attributes than the ones stated in class. Our Tickets also hold a description of the issue, an appropriate solution, and a flag for resolved or not resolved. 

Future embellishments include: 

- Feedback for whether or not the solution worked
- An update status method that notifies the state of your issue (resolved or not)