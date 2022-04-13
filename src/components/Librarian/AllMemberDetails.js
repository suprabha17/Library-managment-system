import { MDBDataTableV5 } from "mdbreact";
// import {useState} from 'react';
import ApiService from "../../services/ApiService";
// import "./AllMemberDetails.css";
import { Link } from "react-router-dom";
// import React, { Component }  from 'react';
// import React from 'react';
import React, { useEffect, useState } from "react";
import { NavLink } from "react-router-dom/cjs/react-router-dom.min";
import { ToastContainer, toast } from 'react-toastify';
  import 'react-toastify/dist/ReactToastify.css';

 
 
const AllMemberDetails = () => {
 
    const [users, setUsers] = useState([]);
 
    const init = () => {
     ApiService.allmemberdetails()
        .then(response => {
          console.log('+++++++++Printing users data', response.data);
          setUsers(response.data);
 
        })
        .catch(error => {
         
          console.log('Something went wrong', error);
        })
 
    }
    useEffect(() => {
        init();
      }, []);
 
      const handleDelete = (id) => {
        console.log('Printing id', id);
        ApiService.deleteMember(id)
          .then(response => {
            console.log('user deleted successfully', response.data);
            toast("user deleted successfully");
            init();
          })
          .catch(error => {
           toast("cannot delete member have issued book");
            console.log('Something went wrong', error);
          })
      }
 
      return (
        <>
        <div className="whole-page"  >
        <div className="container" style={{marginTop:"80px"}}>
        <h3>All Members</h3> 
           <div style={{marginTop:"80px"}} >
          <div>
          {/* id,aadhar,first_name,middle_name,last_name, address,email, mobile, password ,dept,join_date,yr_experience,salary */}
            <table className="table table-bordered table-striped" style={{marginTop:"170px"}}>
              <thead className="thead-dark">
                <tr>
                   
                <th>User Id</th>
                <th>User Name</th>
               
                <th>Created At</th>
                <th>Updated At</th>
                <th>Fine</th>
                <th>No.of Books Present</th>
                <th>Email</th>
                <th>Password</th>
                <th>Address</th>
                <th>Update</th>
                <th>Remove</th>
 
                </tr>
              </thead>
              <tbody>
              {
                //id,first_name,middle_name,last_name,gender,address,mobile,dept,dob,join_date,yr_experience,salary,bonus
                users.map(user => (
                  <tr key={user.id}>
                      <td>{user.id}</td>
                      <td>{user.name}</td>
                    
                    <td>{user.createdAt}</td>
                    <td>{user.updatedAt}</td>
                    <td>{user.fine}</td>
                    <td>{user.numOfBooksPresent}</td>
                    <td>{user.email}</td>
                    <td>{user.password}</td>
                    <td>{user.address}</td>
                    {/* <td><Link className="button_update" to={`users/${users.id}`}>Update</Link></td> */}
                    {/* <td>  <button className="button_update" onClick={() => {handleDelete(users.id);}}>Update</button></td> */}
                    <td>  <Link className="button_update" to={`/libr/member/${user.id}`}>Update</Link></td>
                    <td><button className="button_del" onClick={()=>handleDelete(user.id)}>Delete</button></td>
 
                 
                </tr>
                ))
              }
              </tbody>
            </table>
            <div className="issuebtn">
            <Link to="/LibrarianHome"> <button onClick={(e) => AllMemberDetails(e)} className="btn btn-primary">Back</button></Link>
       
             </div>
          </div>
        </div>
       </div>
       </div>
       <ToastContainer/>
       </>
      );
            }
 
            export default AllMemberDetails;        

