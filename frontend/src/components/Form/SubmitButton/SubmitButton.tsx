import React from 'react';
import './styles.css';

export default function componentName({ type, text, onSubmit,onClick }:any) {
  return (
    <div className='btns'>
      <button className="btn">{text}</button>
    </div>
  );
}
