import os
import re

# 要處理的副檔名
target_extensions = ['.java']

def add_api_model_property_to_java(filepath):
    with open(filepath, 'r', encoding='utf-8') as f:
        lines = f.readlines()

    modified = False
    new_lines = []
    already_imported = any("import io.swagger.annotations.ApiModelProperty;" in line for line in lines)

    for i, line in enumerate(lines):
        # 處理 @Excels 情況時，跳過，不支援嵌套 Excel name
        if "@Excels" in line:
            new_lines.append(line)
            continue

        match = re.search(r'@Excel\s*\(\s*name\s*=\s*"([^"]+)"', line)
        if match:
            name = match.group(1)
            indent = re.match(r'\s*', line).group(0)
            # 檢查上一行是否已經有 @ApiModelProperty
            if i == 0 or not re.search(r'@ApiModelProperty', lines[i-1]):
                new_lines.append(f'{indent}@ApiModelProperty(value = "{name}")\n')
                modified = True

        new_lines.append(line)

    # 自動補上 import
    if modified and not already_imported:
        for i, line in enumerate(new_lines):
            if line.strip().startswith("package "):
                # 找到 package 行後，找下一個空白行插入 import
                while i < len(new_lines) and new_lines[i].strip() != "":
                    i += 1
                new_lines.insert(i, "import io.swagger.annotations.ApiModelProperty;\n")
                break

    if modified:
        with open(filepath, 'w', encoding='utf-8') as f:
            f.writelines(new_lines)
        print(f"✅ 修改完成: {filepath}")
    else:
        print(f"⭕ 無需修改: {filepath}")

def process_directory(root_dir):
    for foldername, _, filenames in os.walk(root_dir):
        for filename in filenames:
            filepath = os.path.join(foldername, filename)
            if any(filename.lower().endswith(ext) for ext in target_extensions):
                    add_api_model_property_to_java(filepath)

if __name__ == '__main__':
    current_dir = os.path.dirname(os.path.abspath(__file__))
    process_directory(current_dir)
    print("\n✅ 所有檔案處理完成")