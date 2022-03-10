import './styles.css';

function Input({ type, text, name, placeholder, handleOnChange, value }:any){

    return( 
        <div className='field'>
            <input 
            type={type} 
            name={name} 
            id={name}
            required
            placeholder={placeholder}
            onChange={handleOnChange}
            defaultValue={value}
            />
            <label className="label" htmlFor={text} title={text} data-title={text}></label>
        </div>
    );
}
export default Input;