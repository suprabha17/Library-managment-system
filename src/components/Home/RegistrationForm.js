import { useState } from 'react';
import React from 'react';
// import React, { Component }  from 'react';
import './registration.css';
import { Link } from 'react-router-dom';
import MemberRegistration from './MemberRegistration';

const RegistrationForm = () => {
    const [activeButton, setActiveButton] = useState('member');
    const clickHandler = (e) => {
        setActiveButton(e.target.value);
    }
    return (
        <div className="container-fluid ps-md-0" style= {{marginTop: "56px"}}>    
        <div className="row g-0">
            <div className="d-none d-md-flex col-md-4 col-lg-6 form-video">
            <div className="video-background-holder">
        <div className="video-background-overlay"></div>
        <video playsInline="playsinline" autoPlay="autoplay" muted="muted" loop="loop">
            <source src="https://static.videezy.com/system/resources/previews/000/052/779/original/STACK-BOOK2.mp4" type="video/mp4"/>
        </video>
        <div className="video-background-content container h-100">
            <div className="d-flex h-100 text-center align-items-center">
                <div className="w-100 text-white">
                   
                </div>
            </div>
        </div>
    </div>
            </div>
            <div className="col-md-8 col-lg-6">
                <div className="login d-flex align-items-center py-0">
                    <div className="container">
                        <div className="row">
                            <div className="col-md-9 col-lg-8 mx-auto">
                                <div className="text-center my-container-reg">
                                    <h1 className="display-6 mb-3">Register Now!</h1>
                                    <div className="col-lg-6 mx-auto">
                                        <div className="d-grid gap-2 d-sm-flex justify-content-sm-center">
                                            {/* <button type="button" className={`btn btn-sm btn-outline-dark btn-lg px-3 shadow-none ${activeButton === 'member' ? 'active' : ' '}`} onClick={clickHandler} value='member'>Member</button> */}
                                            {/* <button type="button" className={`btn btn-sm btn-outline-dark btn-lg px-3 shadow-none ${activeButton === 'librarian' ? 'active' : ' '}`} onClick={clickHandler} value='librarian'>Librarian</button> */}
                                        </div>
                                    </div>
                                    <div className="signup-form">
                                        { activeButton === 'member' ? <MemberRegistration/> : <MemberRegistration/> }
                                        <div className="hint-text">Already have an account? <Link to="/login" style={{textDecoration: "none"}}><span>Login here</span></Link></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    )
}

export default RegistrationForm