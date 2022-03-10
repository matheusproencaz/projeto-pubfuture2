import './styles.css';

function Select({ text, name, options, handleOnChange, value }: any) {

    return (
        <div className="formControl">
            <label htmlFor={name}>{text}:</label>
            <select
                name={name}
                id={name}
                onChange={handleOnChange}
                defaultValue={value}
            >
                <option disabled >Selecione uma opção</option>
                {options.map((options:any) => (
                    <option value={options} key={options}>
                        {options}
                    </option>
                ))}
            </select>
        </div>
    );
}

export default Select;