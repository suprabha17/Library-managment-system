import { useForm } from 'react-hook-form';
import React, { useState,useEffect } from 'react';
import classNames from 'classnames';
import { useRef } from 'react';
import ApiService from '../../services/ApiService';
import { useHistory,useParams, } from 'react-router-dom';
import { Link } from "react-router-dom";
import './addBookForm.css';
import 'react-toastify/dist/ReactToastify.css';

import { toast, ToastContainer } from 'react-toastify';
 
function AddBookForm() {
    const [book,setBook] = useState([]);
    const[title, setTitle] = useState('');
    const[author, setAuthor] = useState('');
    const[availabilityCount,  setAvailabilityCount] = useState('');
    const history = useHistory();
      const {id} = useParams();
  
      const saveBook = (e) => {
          e.preventDefault();
  
          const book = {id,title,author,availabilityCount};
          if (id) {
              //update
              ApiService.updateBook(book)
                  .then(response => {
                      console.log('user data updated successfully', response.data);
                      history.push('/allbooksl');
                      toast("book updated successfully");
                  })
                  .catch(error => {
                      console.log('Something went wrong', error);
                      toast("something wen wrong");
                  }) 
          } else {
              //create
              ApiService.addBook(book)
              .then(response => {
                  console.log("user added successfully", response.data);
                  toast("book added successfully");
                  history.push("/addBook");
              })
              .catch(error => {
              toast("something wen wrong");
                  console.log('something went wroing', error);
              })
          }
      }
  
  //title,noOfCopies,author, publisher,language, category
        useEffect(() => {
        if (id) {
          ApiService.bookById(id)
                .then(book => {
                       setTitle(book.data.title);
                      setAvailabilityCount(book.data.availabilityCount);
                      setAuthor(book.data.author);
                   
                })
                .catch(error => {
                    console.log('Something went wrong', error);
                })
        }
    }, [])
      const cancelAddUser=(event)=>{
      event.defaultPrevented();
    }
      return(
        <>
        <div className="whole-page"  >
        <div className="container" style={{marginTop:"80px"}}>
        <h3>Update Book</h3> 
           <div style={{marginTop:"80px"}} >
        
           
            <div className='app-wrapper'>
                <div>
                
                </div>
                <form className='form-wrapper'>
  
                <div className="form-group" class="col-md-3">
                  <label className='label'>Book Name: </label>
                  <input type="text"
                  id="title"
                  className="form-control" 
                  name='title'
                  value={title}
                  onChange={(e) => setTitle(e.target.value)}
                  placeholder="Enter Book name"/>
  
                </div>
                <div className="form-group" class="col-md-3">
                  <label className='label'> Quantity: </label>
                  <input type="text"
                  id="availabilityCount"
                  className="form-control"
                  name='availabilityCount'
                  value={availabilityCount}
                  onChange={(e) => setAvailabilityCount(e.target.value)}
                  placeholder="Enter Quantity"/>
                </div>
                  
                <div className="form-group" class="col-md-3">
                  <label className='label'>Author Name: </label>
                  <input type="text"
                  id="author"
                  className="form-control"
                  name='author' 
                  value={author}
                  onChange={(e) => setAuthor(e.target.value)}
                  placeholder="Enter author"/>
  
                </div>
               
  
                <div className="form-group" class="col-md-3">
                  <br/>
                  
                  <button  onClick={(e) => saveBook(e)} class="btn btn-primary col-md-5" type="submit">Add Book</button>
                  {/* <button type='button' className='cancel' onClick={cancelAddUser} > Back</button> */}
                  <br/>
                  <br/>
                  <br/>
                  <Link to="/LibrarianHome"><button className="submit">Back</button></Link>
                </div>
  
  
                </form>
             </div>
      </div>   
      </div>
      </div>
      <ToastContainer/>
      </>
     )
  }
  
  export default AddBookForm;
