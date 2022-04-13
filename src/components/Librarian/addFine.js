import { MDBDataTableV5 } from "mdbreact";
// import {useState} from 'react';
import ApiService from "../../services/ApiService";
// import "./Fine.css";
import { Link } from "react-router-dom";
// import React, { Component }  from 'react';
// import React from 'react';
import "./background.css";
import React, { useEffect, useState } from "react";
import { ToastContainer, toast } from 'react-toastify';
  import 'react-toastify/dist/ReactToastify.css';
 
const Fine = () => {
 
    const [books, setBooks] = useState([]);
    const[user,setuser]=useState(JSON.parse(localStorage.getItem('user')))  ;
    const init = () => {
     
 
     ApiService.bookForFine()
        .then(response => {
           
          console.log('+++++++++Printing users data', response.data);
         
          setBooks(response.data);
 
        })
        .catch(error => {
          console.log('Something went wrong', error);
        })
 
    }
    useEffect(() => {
        init();
      }, []);

      const addFineToMember = (id) => {
        console.log('Printing id', id);
        ApiService.addFineToMember(id)
          .then(response => {
            console.log('user deleted successfully', response.data);
            toast("fine added successfully");
            init();
          })
          .catch(error => {
           
            console.log('cannot add', error);

          })
      }
      return (
        <>
        <div className="whole-page"  >
        <div className="container" style={{marginTop:"80px"}}>
        <h3>Add fine</h3> 
           <div style={{marginTop:"80px"}} >
        
           <div>
          
        
   
                   
         
            <div>
          {/* id,aadhar,first_name,middle_name,last_name, address,email, mobile, password ,dept,join_date,yr_experience,salary */}
            <table className="table table-bordered table-striped" style={{marginTop:"170px"}}>
              <thead className="thead-dark">
                 
                <tr>
                   
                <th>Issue Id</th>  
                <th>Book Id</th>
                <th>Member Id</th>
                <th>Issue Date</th>
                <th>Return Date</th>              
                 <th>Expected Return Date</th>
                 <th>Renew Date</th>
                 <th>No.of times renewed</th>
                 <th>Fine</th>
                 <th>Action</th>
                 {/* <th>reservation</th> */}
 
                </tr>
              </thead>
              <tbody>
              {
                //id,first_name,middle_name,last_name,gender,address,mobile,dept,dob,join_date,yr_experience,salary,bonus
                books.map(books => (
                  <tr key={books.id}>
                      <td>{books.issueId}</td>
                    <td>{books.bookId}</td>
                    <td>{books.memberId}</td>
                    <td>{books.issuedOn}</td>
                    <td>{books.returnDate}</td>
 
                    <td>{books.expectedReturn}</td>
                    <td>{books.renewedAt}</td>
                    <td>{books.numOfTimesRenewed}</td>
                    <td>{books.fineOnBook}</td>
                    <td><button className="button_del" onClick={()=>addFineToMember(books.issueId)}>add Fine</button></td>
                    {/* onClick={() => {handleUpdate(user.id);}} */}
                    </tr>
                ))
              }
              </tbody>
            </table>
            <div className="issuebtn">
            <Link to="/LibrarianHome"> <button  className="btn btn-primary">Back</button></Link>
       
             </div>
          </div>
        </div>
        </div>
         </div>
         </div>
         <ToastContainer/>
        </>
      );
            }
 
            export default Fine;        

